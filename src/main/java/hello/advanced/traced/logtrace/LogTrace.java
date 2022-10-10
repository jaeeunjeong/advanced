package hello.advanced.traced.logtrace;

import hello.advanced.traced.TraceStatus;
/**
 * 로그 추척에 필요한 최소한의 기능만 남김
 */
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
