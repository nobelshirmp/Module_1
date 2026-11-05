public class Programm {
    public static void main(String[] args) {
        ExampleImmutable exampleImmutable1 = new ExampleImmutable();
        ExampleImmutable exampleImmutable2 = new ExampleImmutable(123);
        ExampleImmutable exampleImmutable3 = new ExampleImmutable(new ExampleImmutable.ContainedClass());

        exampleImmutable1.containedClass.setNumber(555);
        var result = exampleImmutable1.containedClass.getNumber() + exampleImmutable2.containedClass.getNumber();
        exampleImmutable2.containedClass.setNumber(result);
        exampleImmutable3.containedClass.setNumber(888);

        System.out.println("\nUse sout format from main.");
        showInfoDefaultFormat(exampleImmutable1, 1);
        showInfoDefaultFormat(exampleImmutable2, 2);
        showInfoDefaultFormat(exampleImmutable3, 3);

        System.out.println("\nUse sout format from Override toString");
        showInfoOverrideFormat(exampleImmutable1);
        showInfoOverrideFormat(exampleImmutable2);
        showInfoOverrideFormat(exampleImmutable3);

    }

    static void showInfoDefaultFormat(ExampleImmutable target, int index){
        System.out.printf("ExampleImmutable - %d\n", index);
        System.out.printf("Contained class value is %d\n", target.containedClass.getNumber());
    }

    static void showInfoOverrideFormat(ExampleImmutable target){
        System.out.println(target.toString());
    }
}
