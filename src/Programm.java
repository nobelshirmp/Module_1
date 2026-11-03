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
        ShowInfoDefaultFormat(exampleImmutable1, 1);
        ShowInfoDefaultFormat(exampleImmutable2, 2);
        ShowInfoDefaultFormat(exampleImmutable3, 3);

        System.out.println("\nUse sout format from Override toString");
        ShowInfoOverrideFormat(exampleImmutable1);
        ShowInfoOverrideFormat(exampleImmutable2);
        ShowInfoOverrideFormat(exampleImmutable3);

    }

    static void ShowInfoDefaultFormat(ExampleImmutable target, int index){
        System.out.printf("ExampleImmutable - %d", index);
        System.out.printf("Contained class value is %d", target.containedClass.getNumber());
    }

    static void ShowInfoOverrideFormat(ExampleImmutable target){
        System.out.println(target.toString());
    }
}
