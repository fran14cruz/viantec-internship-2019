package rubin.ru.dao.utils;

import com.google.common.collect.ImmutableMap;
import rubin.ru.dao.enums.Standard;
import rubin.ru.dao.enums.TimeFrame;
import rubin.ru.model.Sort;

import java.time.LocalDateTime;

public class PointEventUtils {

    public static String getStandard(Integer frequency) {
        Standard standard =
                frequency <= 14 && frequency >= 1
                        ? Standard.BGN
                        : frequency <= 0 ? Standard.UNKNOWN : Standard.A;

        return standard.getName();
    }

    public static String channelFrequencyFormatter(Integer frequency) {
        ImmutableMap<Integer, String> numberChannel =
                ImmutableMap.<Integer, String>builder()
                        .put(1, "(2.412 МГц)")
                        .put(2, "(2.417 МГц)")
                        .put(3, "(2.422 МГц)")
                        .put(4, "(2.427 МГц)")
                        .put(5, "(2.432 МГц)")
                        .put(6, "(2.437 МГц)")
                        .put(7, "(2.442 МГц)")
                        .put(8, "(2.447 МГц)")
                        .put(9, "(2.452 МГц)")
                        .put(10, "(2.457 МГц)")
                        .put(11, "(2.462 МГц)")
                        .put(12, "(2.467 МГц)")
                        .put(13, "(2.472 МГц)")
                        .put(14, "(2.484 МГц)")
                        .put(16, "(5.080 МГц)")
                        .put(34, "(5.170 МГц)")
                        .put(36, "(5.180 МГц)")
                        .put(38, "(5.190 МГц)")
                        .put(40, "(5.200 МГц)")
                        .put(42, "(5.210 МГц)")
                        .put(44, "(5.220 МГц)")
                        .put(46, "(5.230 МГц)")
                        .put(48, "(5.240 МГц)")
                        .put(50, "(5.250 МГц)")
                        .put(52, "(5.260 МГц)")
                        .put(54, "(5.270 МГц)")
                        .put(56, "(5.280 МГц)")
                        .put(58, "(5.290 МГц)")
                        .put(60, "(5.300 МГц)")
                        .put(62, "(5.310 МГц)")
                        .put(64, "(5.320 МГц)")
                        .put(100, "(5.500 МГц)")
                        .put(102, "(5.510 МГц)")
                        .put(104, "(5.520 МГц)")
                        .put(106, "(5.530 МГц)")
                        .put(108, "(5.540 МГц)")
                        .put(110, "(5.550 МГц)")
                        .put(112, "(5.560 МГц)")
                        .put(114, "(5.570 МГц)")
                        .put(116, "(5.580 МГц)")
                        .put(118, "(5.590 МГц)")
                        .put(120, "(5.600 МГц)")
                        .put(122, "(5.610 МГц)")
                        .put(124, "(5.620 МГц)")
                        .put(126, "(5.630 МГц)")
                        .put(128, "(5.640 МГц)")
                        .put(132, "(5.660 МГц)")
                        .put(134, "(5.680 МГц)")
                        .put(136, "(5.680 МГц)")
                        .put(138, "(5.690 МГц)")
                        .put(140, "(5.700 МГц)")
                        .put(142, "(5.710 МГц)")
                        .put(144, "(5.720 МГц)")
                        .put(147, "(5.735 МГц)")
                        .put(149, "(5.745 МГц)")
                        .put(151, "(5.755 МГц)")
                        .put(152, "(5.760 МГц)")
                        .put(153, "(5.765 МГц)")
                        .put(155, "(5.775 МГц)")
                        .put(157, "(5.785 МГц)")
                        .put(159, "(5.795 МГц)")
                        .put(160, "(5.800 МГц)")
                        .put(161, "(5.805 МГц)")
                        .put(163, "(5.815 МГц)")
                        .put(165, "(5.825 МГц)")
                        .put(167, "(5.835 МГц)")
                        .put(169, "(5.845 МГц)")
                        .put(171, "(5.855 МГц)")
                        .put(173, "(5.865 МГц)")
                        .put(177, "(5.885 МГц)")
                        .put(180, "(5.905 МГц)")
                        .build();

        return frequency + " " + numberChannel.get(frequency);
    }

    public static TimeFrame getTimeFrame(LocalDateTime dateTime) {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        if (dateTimeNow.minusSeconds(300).isAfter(dateTime)) {
            return TimeFrame.MORE_300;
        }

        if (dateTimeNow.minusSeconds(30).isBefore(dateTime)) {
            return TimeFrame.LESS_30;
        }

        if (dateTimeNow.minusSeconds(60).isBefore(dateTime)) {
            return TimeFrame.LESS_60;
        }

        if (dateTimeNow.minusSeconds(300).isBefore(dateTime)) {
            return TimeFrame.LESS_300;
        }

        return null;
    }

    public static String buildPartSortQuery(Sort sort) {

        String direction = sort.getDirection();
        String field = sort.getField();

        if (field != null) {
            switch (sort.getField()) {
                case "mac":
                    return createSortQuery(direction, "MAC");
                case "name":
                    return createSortQuery(direction, "POINT_NAME");
                case "vendor":
                    return createSortQuery(direction, "VENDOR_NAME");
                case "lastDateTime":
                    return createSortQuery(direction, "LAST_DATE_TIME");
                case "coding":
                    return createSortQuery(direction, "CODING");
                case "standard":
                    return createSortQuery(direction, "FREQUENCY");
                case "packages":
                    return createSortQuery(direction, "PACKAGES");
                case "frequency":
                    return createSortQuery(direction, "FREQUENCY");
                case "level":
                    return createSortQuery(direction, "POINT_LEVEL");
                case "pointList":
                    return createSortQuery(direction, "ID_LIST");
                case "clientCount":
                    return createSortQuery(direction, "CLIENT_COUNT");
                default:
                    return "";
            }
        }
        return "";
    }

    private static String createSortQuery(String direction, String sqlFieldName) {
        return " ORDER BY " + sqlFieldName + " " + direction + " ";
    }

}


