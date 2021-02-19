package com.quadsquad.core.values.location;

public class GeoLocationValue {

    private LatitudeValue latitude;
    private LongitudeValue longitude;
    private AltitudeValue altitude;

    private GeoLocationValue() {
    }

    public boolean isValid() {
        return (
                latitude.isValid()
                        && longitude.isValid()
                        && altitude.isValid()
        );
    }

    public static Builder newBuilder() {
        return new Builder() ;
    }

    public Builder toBuilder() {

        return newBuilder()
                .setLatitude(latitude)
                .setLongitude(longitude)
                .setAltitude(altitude)
                ;

    }

    public LatitudeValue getLatitude() {
        return latitude;
    }

    public LongitudeValue getLongitude() {
        return longitude;
    }

    public AltitudeValue getAltitude() {
        return altitude;
    }

    public GeoLocationValue copy() {
        return toBuilder()
                .build()
                ;
    }

    public static class Builder {

        private LatitudeValue latitude;
        private LongitudeValue longitude;
        private AltitudeValue altitude;

        public GeoLocationValue build() {

            if (latitude == null) latitude = LatitudeValue.ofMin() ;
            if (longitude == null) longitude = LongitudeValue.ofMin() ;
            if (altitude == null) altitude = AltitudeValue.ofMin();

            final GeoLocationValue geoLocation = new GeoLocationValue() ;
            geoLocation.latitude = latitude;
            geoLocation.longitude = longitude;
            geoLocation.altitude = altitude;

            return geoLocation ;
        }

        public Builder setLatitude(double value) {
            this.latitude = LatitudeValue.of(value);
            return this ;
        }

        public Builder setLongitude(double value) {
            this.longitude = LongitudeValue.of(value);
            return this ;
        }

        public Builder setAltitude(double value) {
            this.altitude = AltitudeValue.of(value);
            return this ;
        }

        public Builder setLatitude(LatitudeValue latitude) {

            if (latitude == null) return this ;
            this.latitude = latitude.copy();

            return this ;
        }

        public Builder setLongitude(LongitudeValue longitude) {

            if (longitude == null) return this ;
            this.longitude = longitude.copy();

            return this ;
        }

        public Builder setAltitude(AltitudeValue altitude) {

            if (altitude == null) return this ;
            this.altitude = altitude.copy();

            return this ;
        }

        public Builder setGeoLocation(GeoLocationValue geoLocation) {

            if (geoLocation == null) return this ;

            this.latitude = geoLocation.latitude.copy();
            this.longitude = geoLocation.longitude.copy();
            this.altitude = geoLocation.altitude.copy();

            return this ;
        }
    }
}
