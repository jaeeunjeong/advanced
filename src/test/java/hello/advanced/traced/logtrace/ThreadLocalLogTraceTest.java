package hello.advanced.traced.logtrace;

import hello.advanced.traced.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ThreadLocalLogTraceTest {
    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @DisplayName("쓰레드 로컬이 제대로 작동하는지 확인")
    @Test
    void test1() {
        TraceStatus status1 = trace.begin("status1");
        TraceStatus status2 = trace.begin("status2");
        trace.end(status2);
        trace.end(status1);
    }

    @DisplayName("쓰레드 로컬 에러 확인")
    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("status1");
        TraceStatus status2 = trace.begin("status2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}