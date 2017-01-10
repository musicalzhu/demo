package niu.common;

public interface Observer {
	void update(Subject subject, Object arg);
}
