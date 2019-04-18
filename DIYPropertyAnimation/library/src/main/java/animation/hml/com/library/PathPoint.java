package animation.hml.com.library;

/**
 * Created by hml on 2019/4/12.
 */
public class PathPoint {

    public Operation mOperation;
    public float mX;
    public float mY;
    public int mControl0X;//控制点1的x
    public int mControl0Y;//控制点1的y
    public int mControl1X;//控制点2的x
    public int mControl1Y;//控制点2的y

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
