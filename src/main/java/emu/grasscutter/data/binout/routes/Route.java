package emu.grasscutter.data.binout.routes;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Route {
    private int localId;
    private String name;
    private RouteType type = RouteType.Unknown;
    private RoutePoint[] points;
    private float arriveRange; // optional
    private RotType rotType; // optional
    private RotAngleType rotAngleType; // optional

    public emu.grasscutter.net.proto.Route toProto() {
        val builder = emu.grasscutter.net.proto.Route.newBuilder().setRouteType(type.getValue());
        if (points != null) {
            for (var routePoint : points) {
                builder.addRoutePoints(routePoint.toProto().setArriveRange(arriveRange));
            }
        }
        return builder.build();
    }
}
