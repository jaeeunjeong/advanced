package hello.advanced.traced.logtrace;

import hello.advanced.traced.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {
    FieldLogTrace trace = new FieldLogTrace();

    @DisplayName("제대로 로그가 생성되어 관리되는지 확인 - status1이 trace에 먼저 생성되고 그의 꼬리로 status2가 생성된다.")
    @Test
    void test1() {
        TraceStatus status1 = trace.begin("status1");
        TraceStatus status2 = trace.begin("status2");
        trace.end(status2);
        trace.end(status1);
    }

    @DisplayName("에러가 제대로 작동하는지 확인.")
    @Test
    void test2() {
        TraceStatus status1 = trace.begin("status1");
        TraceStatus status2 = trace.begin("status2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}