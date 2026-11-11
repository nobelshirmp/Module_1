public class Programm {

    public static void main(String[] args) {
        ExampleImmutable exampleImmutable = new ExampleImmutable();
        exampleImmutable.add(123, "test - 1");
        exampleImmutable.add(777, "test - 2");
        exampleImmutable.add(new ExampleImmutable.ContainedClass(123, "test - 3"));
        exampleImmutable.add(new ExampleImmutable.ContainedClass(123, "error"));
        exampleImmutable.add(444, "error");

        System.out.println(exampleImmutable.toString());

        System.out.println("\nTest find all object with number - 123");

        for (var item : exampleImmutable.findContainers(x -> x.getNumber() == 123)){
            System.out.println(item.toString());
        }

        System.out.println("\nTest find all object with tag - error");

        for (var item : exampleImmutable.findContainers(x -> x.getTag().equals("error"))){
            System.out.println(item.toString());
        }

        System.out.println("\nTest find first object with number - 123");

        System.out.println(exampleImmutable.findContainer(x -> x.getNumber() == 123));

        System.out.println("\nTest error number - 999");

        System.out.println(exampleImmutable.findContainer(x -> x.getNumber() == 999));
    }
}
