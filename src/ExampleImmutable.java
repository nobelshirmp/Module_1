import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.function.Predicate;

public final class ExampleImmutable {

    private final LinkedList<ContainedClass> containers;
    private final LocalDateTime createTime;

    public ExampleImmutable() {
        containers = new LinkedList<>();
        createTime =  LocalDateTime.now();
    }

    public void add(final ContainedClass container){ containers.add(container); }
    public void add(int number, String tag){ containers.add(new ContainedClass(number, tag)); }

    public void remove(final ContainedClass container){containers.remove(container); }

    public List<ContainedClass> findContainers(Predicate<ContainedClass> predicate){

        List<ContainedClass> result = new ArrayList<>();

        if(predicate != null) {

            for (ContainedClass item : containers){
                if(predicate.test(item)){
                    result.add(item);
                }
            }
        }

        return result;
    }

    public ContainedClass findContainer(Predicate<ContainedClass> predicate){

        ContainedClass result = ContainedClass.empty();

        if (predicate != null){
            for(ContainedClass item : containers){
                if(predicate.test(item)){
                    result = item;
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("I *%s* contained %d inner classes.", super.toString(), containers.size()));
        builder.append("\nShow all containers info:");

        for (ContainedClass item : containers){
            builder.append(String.format("\n%s", item.toString()));
        }

        builder.append(String.format("\nCreate time - %s", createTime.toString()));

        return builder.toString();
    }

    static class ContainedClass{
        private String tag;
        private int number;

        public ContainedClass(int number, String tag){
            this.number = number;
            this.tag = tag;
        }

        public String getTag(){ return  tag; };
        public int getNumber() { return number; }
        public void setNumber(int value){ number = value;}

        @Override
        public String toString() {
            return  String.format("I *%s* contain value %d and tag %s", super.toString(), number, tag);
        }

        public static ContainedClass empty(){
            return new ContainedClass(Integer.MIN_VALUE, "Empty");
        }
    }
}