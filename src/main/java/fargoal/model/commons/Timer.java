package fargoal.model.commons;

public class Timer {
    
    private long time;

    public void setTime(long time) {
        this.time = time;
    }

    public long updateTime(long elapsed) {
        this.time = this.time - elapsed;
        if (this.time < 0) {
            this.time = 0;
        }
        return this.time;
    }
}
