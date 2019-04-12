package animation.hml.com.library;

/**
 * Created by hml on 2019/4/12.
 */
public class PathPoint {

    public Operation mOperation;
    public float mX;
    public float mY;

    public PathPoint(Operation operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }


    public enum Operation{
        CUBIC,//贝塞尔曲线
        LINE,//直线运动
        MOVE,//运动
    }

}
