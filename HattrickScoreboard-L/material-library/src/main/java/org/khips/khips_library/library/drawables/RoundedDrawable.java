package org.khips.khips_library.library.drawables;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by romain
 * on 14/12/2014.
 */
public class RoundedDrawable extends Drawable {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int radius = 10;

    public RoundedDrawable(int color, int radius) {
        this.radius = radius;
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(new RectF(0,0,canvas.getWidth(), canvas.getHeight()), radius, radius,  paint);
    }

    @Override
    public void setAlpha(int i) {
        paint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return Color.alpha(paint.getColor());
    }
}
