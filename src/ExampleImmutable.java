public final class ExampleImmutable {

    final ContainedClass containedClass;

    public ExampleImmutable() {
        containedClass = new ContainedClass();
    }

    public ExampleImmutable(int number){
        containedClass = new ContainedClass();
        containedClass.setNumber(number);
    }

    public ExampleImmutable(ContainedClass containedClass){
        this.containedClass = containedClass;
    }

    @Override
    public String toString() {
        return String.format("I *%s* contain class with value %d", super.toString(), containedClass.number);
    }

    static class ContainedClass{
        private int number;

        public void setNumber(int value) {
            number = value;
        }

        public int getNumber(){
            return number;
        }
    }
}