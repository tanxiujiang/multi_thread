package harry.tan.reentrantLock;

public interface IBuffer {
    public void write();

    public void read() throws InterruptedException;
}
