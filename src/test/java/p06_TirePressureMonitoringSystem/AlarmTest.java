package p06_TirePressureMonitoringSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {
    private Alarm alarm;
    private Sensor sensor;

    @BeforeEach
    public void setUp() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void test_PressureBiggerThanThreshold_AlarmIsOn() {
        when(sensor.popNextPressurePsiValue()).thenReturn(30.00);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_PressureLowerThanThreshold_AlarmIsOn() {
        when(sensor.popNextPressurePsiValue()).thenReturn(10.00);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_PressureWithinThreshold_AlarmIsOff() {
        when(sensor.popNextPressurePsiValue()).thenReturn(19.00);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }
}
