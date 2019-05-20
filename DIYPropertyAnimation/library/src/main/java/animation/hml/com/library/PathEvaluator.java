package animation.hml.com.library;

import android.animation.TypeEvaluator;
import android.util.Log;


/**
 * Created by hml on 2019/4/12.
 */
public class PathEvaluator implements TypeEvaluator<PathPoint> {
    private static final String TAG = "PathEvaluator";
    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x = 0;
        float y = 0;

        if (startValue.mOperation == PathPoint.Operation.CUBIC){
//            贝塞尔曲线三次方公式   B(t) = P0*(1-t)^3 + 3*P1*t*(1-t)^2 + 3*P2*t^2*(1-t)+P3*t^3 , t∈[0,1]
            float oneMinusT = 1 - t;
            x = startValue.mX * oneMinusT * oneMinusT * oneMinusT +
                    3 * startValue.mControl0X * t * oneMinusT * oneMinusT +
                    3 * startValue.mControl1X * t * t * oneMinusT +
                    endValue.mX * t * t * t;
            y = startValue.mY * oneMinusT * oneMinusT * oneMinusT +
                    3 * startValue.mControl0Y * t * oneMinusT * oneMinusT +
                    3 * startValue.mControl1Y * t * t * oneMinusT +
                    endValue.mY * t * t * t;

        }else if (startValue.mOperation == PathPoint.Operation.LINE){
            Log.d(TAG,"t = "+t);
            x = startValue.mX + t * (endValue.mX - startValue.mX);
            y = startValue.mY + t * (endValue.mY - startValue.mY);
        }
        return new PathPoint(x,y);
    }
}
