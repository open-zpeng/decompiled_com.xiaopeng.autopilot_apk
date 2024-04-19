package com.xiaopeng.speech.protocol.node.scene;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class SceneNode_Processor implements ICommandProcessor {
    private SceneNode a;

    public SceneNode_Processor(SceneNode sceneNode) {
        this.a = sceneNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1722601438:
                if (str.equals("scene.vui.disable")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1546876663:
                if (str.equals("scene.vui.enable")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 720644575:
                if (str.equals("scene.dm.start")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 828241388:
                if (str.equals("command://scene.control")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1045003449:
                if (str.equals("scene.rebuild")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1301293464:
                if (str.equals("scene.dm.end")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.a.onSceneEvent(str, str2);
                return;
            case 1:
                this.a.onDMStart(str, str2);
                return;
            case 2:
                this.a.onDMEnd(str, str2);
                return;
            case 3:
                this.a.onVuiEnable(str, str2);
                return;
            case 4:
                this.a.onVuiDisable(str, str2);
                return;
            case 5:
                this.a.onRebuild(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://scene.control", "scene.dm.start", "scene.dm.end", "scene.vui.enable", "scene.vui.disable", "scene.rebuild"};
    }
}
