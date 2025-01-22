public class Conversoes {

    private void conversaoImplicita() {
        byte a = 10;
        short b = a;   // byte para short (implicita)
        int c = b;     // short para int (implicita)
        long d = c;    // int para long (implicita)
        float e = d;   // long para float (implicita)
        double f = e;  // float para double (implicita)
    }

    private void conversaoExplicita() {
        double a = 9.78;
        float b = (float) a;   // double para float (explicita)
        long c = (long) b;     // float para long (explicita)
        int d = (int) c;       // long para int (explicita)
        short e = (short) d;    // int para short (explicita)
        byte f = (byte) e;     // short para byte (explicita)
    }

    private void autoBoxing() {
        int primitiveInt = 5;
        Integer objectInt = primitiveInt;  // Auto-boxing ou boxing
    }

    private void unboxing() {
        Integer objectInt = 10;
        int primitiveInt = objectInt;  // Unboxing
    }

    private void conversaoPorMetodos() {
        Byte.parseByte("2");
        Short.parseShort("2");
        Integer.parseInt("4");
        Long.parseLong("120");
        Float.parseFloat("1654.28");
        Double.parseDouble("156745.00000485");
        Boolean.parseBoolean("true");

        Byte.valueOf("4");
        Short.valueOf("120");
        Integer.valueOf("4");
        Long.valueOf("120");
        Float.valueOf("1654.28");
        Double.valueOf("156745.00000485");
        Boolean.valueOf("true");

        Byte a = 0;
        Short b = 5;
        Integer c = 10;
        Long d = 15L;
        Float e = 20F;
        Double f = 25D;

        a.toString();
        b.toString();
        c.toString();
        d.toString();
        e.toString();
        f.toString();

        a.byteValue();
        a.shortValue();
        a.intValue();
        a.longValue();
        a.floatValue();
        a.doubleValue();

        b.byteValue();
        b.shortValue();
        b.intValue();
        b.longValue();
        b.floatValue();
        b.doubleValue();

        c.byteValue();
        c.shortValue();
        c.intValue();
        c.longValue();
        c.floatValue();
        c.doubleValue();

        d.byteValue();
        d.shortValue();
        d.intValue();
        d.longValue();
        d.floatValue();
        d.doubleValue();

        e.byteValue();
        e.shortValue();
        e.intValue();
        e.longValue();
        e.floatValue();
        e.doubleValue();

        f.byteValue();
        f.shortValue();
        f.intValue();
        f.longValue();
        f.floatValue();
        f.doubleValue();
    }
}