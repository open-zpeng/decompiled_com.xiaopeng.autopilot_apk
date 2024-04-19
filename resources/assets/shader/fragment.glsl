#ifdef GL_ES
#define LOWP lowp
#define MED mediump
#define HIGH highp
precision mediump float;
#else
#define MED
#define LOWP
#define HIGH
#endif

//镜面纹理
#if defined(specularTextureFlag) || defined(specularColorFlag)
#define specularFlag
#endif
//法线
#ifdef normalFlag
varying vec3 v_normal;
#endif //normalFlag

//颜色
#if defined(colorFlag)
varying vec4 v_color;
#endif

//混合/apl测试
#ifdef blendedFlag
varying float v_opacity;
#ifdef alphaTestFlag
varying float v_alphaTest;
#endif //alphaTestFlag
#endif //blendedFlag

//纹理 漫反射/镜面反射/自发光
#if defined(diffuseTextureFlag) || defined(specularTextureFlag) || defined(emissiveTextureFlag)
#define textureFlag
#endif

//漫反射纹理
#ifdef diffuseTextureFlag
varying MED vec2 v_diffuseUV;
#endif

//镜面反射纹理
#ifdef specularTextureFlag
varying MED vec2 v_specularUV;
#endif

//自发光纹理
#ifdef emissiveTextureFlag
varying MED vec2 v_emissiveUV;
#endif


#ifdef diffuseColorFlag
uniform vec4 u_diffuseColor;
#endif

#ifdef diffuseTextureFlag
uniform sampler2D u_diffuseTexture;
#endif

#ifdef specularColorFlag
uniform vec4 u_specularColor;
#endif

#ifdef specularTextureFlag
uniform sampler2D u_specularTexture;
#endif

#ifdef normalTextureFlag
uniform sampler2D u_normalTexture;
#endif

#ifdef emissiveColorFlag
uniform vec4 u_emissiveColor;
#endif

#ifdef emissiveTextureFlag
uniform sampler2D u_emissiveTexture;
#endif

#ifdef lightingFlag
varying vec3 v_lightDiffuse;

#if	defined(ambientLightFlag) || defined(ambientCubemapFlag) || defined(sphericalHarmonicsFlag)
#define ambientFlag
#endif //ambientFlag

#ifdef specularFlag
varying vec3 v_lightSpecular;
#endif //specularFlag

#ifdef shadowMapFlag
uniform sampler2D u_shadowTexture;
uniform float u_shadowPCFOffset;
varying vec3 v_shadowMapUv;
#define separateAmbientFlag

float getShadowness(vec2 offset)
{
    const vec4 bitShifts = vec4(1.0, 1.0 / 255.0, 1.0 / 65025.0, 1.0 / 16581375.0);
    return step(v_shadowMapUv.z, dot(texture2D(u_shadowTexture, v_shadowMapUv.xy + offset), bitShifts));//+(1.0/255.0));
}

float getShadow()
{
	return (//getShadowness(vec2(0,0)) +
			getShadowness(vec2(u_shadowPCFOffset, u_shadowPCFOffset)) +
			getShadowness(vec2(-u_shadowPCFOffset, u_shadowPCFOffset)) +
			getShadowness(vec2(u_shadowPCFOffset, -u_shadowPCFOffset)) +
			getShadowness(vec2(-u_shadowPCFOffset, -u_shadowPCFOffset))) * 0.25;
}
#endif //shadowMapFlag

#if defined(ambientFlag) && defined(separateAmbientFlag)
varying vec3 v_ambientLight;
#endif //separateAmbientFlag

#endif //lightingFlag

#ifdef fogFlag
uniform vec4 u_fogColor;
varying float v_fog;
#endif // fogFlag

varying vec4 v_position;
//聚光灯
#if defined(lightingFlag) && (numSpotLights >0)
struct SpotLight
{
	vec3 position;
	vec3 direction;
	vec3 color;
	float intensity;
	float cutoffAngle;
	float exponent;
};
uniform SpotLight u_spotLights[numSpotLights];
#endif// spotsLights


void main() {

	#if defined(lightingFlag)
	vec3 v_lightDiffuseTmp = v_lightDiffuse;
	#endif

	#if defined(normalFlag)
		vec3 normal = v_normal;
	#endif // normalFlag

	#if defined(diffuseTextureFlag) && defined(diffuseColorFlag) && defined(colorFlag)
		vec4 diffuse = texture2D(u_diffuseTexture, v_diffuseUV) * u_diffuseColor * v_color;
	#elif defined(diffuseTextureFlag) && defined(diffuseColorFlag)
		vec4 diffuse = texture2D(u_diffuseTexture, v_diffuseUV) * u_diffuseColor;
	#elif defined(diffuseTextureFlag) && defined(colorFlag)
		vec4 diffuse = texture2D(u_diffuseTexture, v_diffuseUV) * v_color;
	#elif defined(diffuseTextureFlag)
		vec4 diffuse = texture2D(u_diffuseTexture, v_diffuseUV);
	#elif defined(diffuseColorFlag) && defined(colorFlag)
		vec4 diffuse = u_diffuseColor * v_color;
	#elif defined(diffuseColorFlag)
		vec4 diffuse = u_diffuseColor;
	#elif defined(colorFlag)
		vec4 diffuse = v_color;
	#else
		vec4 diffuse = vec4(1.0);
	#endif

	#if defined(emissiveTextureFlag) && defined(emissiveColorFlag)
		vec4 emissive = texture2D(u_emissiveTexture, v_emissiveUV) * u_emissiveColor;
	#elif defined(emissiveTextureFlag)
		vec4 emissive = texture2D(u_emissiveTexture, v_emissiveUV);
	#elif defined(emissiveColorFlag)
		vec4 emissive = u_emissiveColor;
	#else
		vec4 emissive = vec4(0.0);
	#endif

	#if defined(lightingFlag) &&  ( numSpotLights > 0)

		vec3 pos = v_position.xyz;

		for (int i = 0; i < numSpotLights; i++) {
			vec3 spotFinalColor = vec3(0.0,0.0,0.0);
			//方向right
			vec3 spotLightDir = normalize(u_spotLights[i].direction);
			//位置 right
			vec3 spotLightPosition = u_spotLights[i].position;
			//颜色 right
			vec3 spotLightColor = u_spotLights[i].color;
			//指数 right
			float  spotLightExponent = u_spotLights[i].exponent;
			//强度 right
			float  spotLightIntensity = u_spotLights[i].intensity;
			//角度 right
			float spotLightCutoffAngle = u_spotLights[i].cutoffAngle;
			//聚光灯夹角余弦值
			float spotLightAngleCosValue = cos(radians(spotLightCutoffAngle));
			//计算光照指向片元方向的向量
			vec3 lightDir = normalize(pos.xyz - spotLightPosition);
			//计算(片段指向光源的方向) 与 聚光灯的方向的角度
			float theta = dot(lightDir,normalize(spotLightDir));
			theta = clamp(theta,0.0,1.0);
			//映射0-1
			float factor = (1.0 - (1.0 - theta) * 1.0/(1.0 - spotLightAngleCosValue));
			//表示在聚光灯内
			if(theta > spotLightAngleCosValue){
				spotFinalColor = spotLightColor * factor * spotLightIntensity ;
				v_lightDiffuseTmp += spotFinalColor;
			}
		}
	#endif// spotsLights

	#if (!defined(lightingFlag))
		gl_FragColor.rgb = diffuse.rgb + emissive.rgb;
	#elif (!defined(specularFlag))
		#if defined(ambientFlag) && defined(separateAmbientFlag)
			#ifdef shadowMapFlag
				gl_FragColor.rgb = (diffuse.rgb * (v_ambientLight + getShadow() * v_lightDiffuseTmp)) + emissive.rgb;
				//gl_FragColor.rgb = texture2D(u_shadowTexture, v_shadowMapUv.xy);
			#else
				gl_FragColor.rgb = (diffuse.rgb * (v_ambientLight + v_lightDiffuseTmp)) + emissive.rgb;
			#endif //shadowMapFlag
		#else
			#ifdef shadowMapFlag
				gl_FragColor.rgb = getShadow() * (diffuse.rgb * v_lightDiffuseTmp) + emissive.rgb;
			#else
				gl_FragColor.rgb = (diffuse.rgb * v_lightDiffuseTmp) + emissive.rgb;
			#endif //shadowMapFlag
		#endif
	#else
		#if defined(specularTextureFlag) && defined(specularColorFlag)
			vec3 specular = texture2D(u_specularTexture, v_specularUV).rgb * u_specularColor.rgb * v_lightSpecular;
		#elif defined(specularTextureFlag)
			vec3 specular = texture2D(u_specularTexture, v_specularUV).rgb * v_lightSpecular;
		#elif defined(specularColorFlag)
			vec3 specular = u_specularColor.rgb * v_lightSpecular;
		#else
			vec3 specular = v_lightSpecular;
		#endif

		#if defined(ambientFlag) && defined(separateAmbientFlag)
			#ifdef shadowMapFlag
			gl_FragColor.rgb = (diffuse.rgb * (getShadow() * v_lightDiffuseTmp + v_ambientLight)) + specular + emissive.rgb;
				//gl_FragColor.rgb = texture2D(u_shadowTexture, v_shadowMapUv.xy);
			#else
				gl_FragColor.rgb = (diffuse.rgb * (v_lightDiffuseTmp + v_ambientLight)) + specular + emissive.rgb;
			#endif //shadowMapFlag
		#else
			#ifdef shadowMapFlag
				gl_FragColor.rgb = getShadow() * ((diffuse.rgb * v_lightDiffuseTmp) + specular) + emissive.rgb;
			#else
				gl_FragColor.rgb = (diffuse.rgb * v_lightDiffuseTmp) + specular + emissive.rgb;
			#endif //shadowMapFlag
		#endif
	#endif //lightingFlag

	#ifdef fogFlag
		gl_FragColor.rgb = mix(gl_FragColor.rgb, u_fogColor.rgb, v_fog);
	#endif // end fogFlag

	#ifdef blendedFlag
		gl_FragColor.a = diffuse.a * v_opacity;
		#ifdef alphaTestFlag
			if (gl_FragColor.a <= v_alphaTest)
				discard;
		#endif
	#else
		gl_FragColor.a = 1.0;
	#endif

}
