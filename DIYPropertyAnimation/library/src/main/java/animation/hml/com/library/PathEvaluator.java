package animation.hml.com.library;

import android.animation.TypeEvaluator;

/**
 * Created by hml on 2019/4/12.
 */
public class PathEvaluator implements TypeEvaluator<PathPoint> {
    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x = 0;
        float y = 0;

        if (endValue.mOperation == PathPoint.Operation.CUBIC){
//            贝塞尔曲线三次方公式   B(t) = P0*(1-t)^3 + 3*P1*t*(1-t)^2 + 3*P2*t^2*(1-t)+P3*t^3 , t∈[0,1]
            float oneMinusT = 1 - t;
            x = startValue.mX * oneMinusT * oneMinusT * oneMinusT +
                    3 * endValue.mControl0X,oneMinusT

        }else if (endValue.mOperation == PathPoint.Operation.LINE){
            x = startValue.mX + t * (endValue.mX - startValue.mX);
            y = startValue.mY + t * (endValue.mY - startValue.mY);
        }else {

        }

        return new PathPoint(PathPoint.Operation.MOVE,x,y);
    }
}
