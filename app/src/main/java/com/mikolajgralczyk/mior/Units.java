package com.mikolajgralczyk.mior;


public class Units {

    public final double quantityToConvert;
    final AbsorbedDoseUnits absorbedUnit;

    public Units(double quantityToConvert, AbsorbedDoseUnits absorbedUnit) {
        this.quantityToConvert = quantityToConvert;
        this.absorbedUnit = absorbedUnit;
    }

    public static enum AbsorbedDoseUnits {
        rad(1.0d), mrad(0.001d), Gy(100.0d), mGy(0.1d), uGy(0.0001d);

        final double byBaseUnit;

        AbsorbedDoseUnits(double v) {
             this.byBaseUnit = v;
        }

        public double toBaseUnit(double value) {
            return value / byBaseUnit;
        }

        public double fromBaseUnit(double value) {
            return value * byBaseUnit;
        }
    }

    public static enum EquivalentDoseUnits {
        rem(1.0d), mrem(0.001d), Sv(100.0d), mSv(0.1d), uSv(0.001d);

        EquivalentDoseUnits(double v) {
            //TODO Po co wgl ten konstruktor??
        }
    }

    public static enum ExposureDoseUnits {
        R(1.0d), mR(0.001d), Ckg(3876.0d), mCkg(3.876d), uCkg(0.003876d);

        ExposureDoseUnits(double v) {
            //TODO
        }
    }

    public static enum InAirUnits {
        Gy(1.0d), cGy(0.01d), mGy(0.001d), Sv(0.000000087d), mSv(0.00087d), uSv(0.87d);

        InAirUnits(double v) {
            //TODO
        }
    }

    public Units to(AbsorbedDoseUnits newUnit) {
        AbsorbedDoseUnits oldUnit = this.absorbedUnit;

        return new Units(newUnit.fromBaseUnit(oldUnit.toBaseUnit(quantityToConvert)), newUnit);
    }


}
