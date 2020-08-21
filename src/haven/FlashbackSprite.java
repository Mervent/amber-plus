package haven;

import java.awt.*;

public class FlashbackSprite extends Sprite {
    private static final Color color = new Color(255, 227, 168);// new Color(235, 235, 235);
    private Tex tex;
    private static Matrix4f mv = new Matrix4f();
    private Projection proj;
    private Coord wndsz;
    private Location.Chain loc;
    private Camera camp;

    public FlashbackSprite(String text) {
        super(null, null);
        update(text);
    }

    public void draw(GOut g) {
        float[] c = mv.load(camp.fin(Matrix4f.id)).mul1(loc.fin(Matrix4f.id)).homoc();
        Coord sc = proj.get2dCoord(c, wndsz);
        sc.x -= tex.sz().x / 2;
        sc.y -= 50;
        g.image(tex, sc);
    }

    public boolean setup(RenderList rl) {
        rl.prepo(last);
        GLState.Buffer buf = rl.state();
        proj = buf.get(PView.proj);
        wndsz = buf.get(PView.wnd).sz();
        loc = buf.get(PView.loc);
        camp = buf.get(PView.cam);
        return true;
    }

    public void update(String text) {
        tex = Text.renderstroked(text, color, Color.BLACK, Text.num12boldFnd).tex();
    }

    public Object staticp() {
        return CONSTANS;
    }
}
