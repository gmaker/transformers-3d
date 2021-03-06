package ru.znay.znay.tt.level.block;

import ru.znay.znay.tt.gfx.Sprite3D;
import ru.znay.znay.tt.level.Level;

/**
 * Created by admin on 01.07.2016.
 */
public class TreeBlock extends GrassBlock {
    public TreeBlock(Level level, int xt, int zt) {
        super(level, xt, zt);
        int c = random.nextInt(3) + 1;
        for (int i = 0; i < c; i++) {
            float x = ((random.nextFloat() - 0.5f)) * 16.0f;
            float z = ((random.nextFloat() - 0.5f)) * 16.0f;
            sprites.add(new Sprite3D(x, 0, z, 16, 0, 16, 32, -8, -8));
            //sprites.add(new Sprite3D(x, 0, z, 16, 2 * 16, 16, 16));
        }
        int rr = 2;
        for (int zz = 0; zz < rr; zz++) {
            for (int xx = 0; xx < rr; xx++) {
                float x = (random.nextFloat() - 0.5f) * 16.0f;
                float z = (random.nextFloat() - 0.5f) * 16.0f;
                float br = 1.0f - random.nextFloat() * 0.3f;
                float r = (1.0f - random.nextFloat() * 0.1f) * br;
                float g = (1.0f - random.nextFloat() * 0.1f) * br;
                float b = (1.0f - random.nextFloat() * 0.1f) * br;
                sprites.add(new Sprite3D(x, 0, z, 0, 32, 16, 16).color(r, g, b, 1.0f));
            }
        }
    }
}
