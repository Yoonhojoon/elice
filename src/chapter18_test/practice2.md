

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static List<Integer> visibleBuildingsFromLeft(List<Integer> heights) {
        List<Integer> visible = new ArrayList<>();
        visible.add(1);
        int max_height = heights.get(0);

        for (int i = 1; i < heights.size(); ++i) {
            if (heights.get(i) > max_height) {
                visible.add(1);
                max_height = heights.get(i);
            } else {
                visible.add(0);
            }
        }

        return visible;
    }

    public static List<Integer> visibleBuildingsFromRight(List<Integer> heights) {
        List<Integer> visible = new ArrayList<>();
        visible.add(1);
        int max_height = heights.get(heights.size() - 1);

        for (int i = heights.size() - 1; i > 0; --i) {
            if (heights.get(i - 1) > max_height) {
                visible.add(0, 1);
                max_height = heights.get(i - 1);
            } else {
                visible.add(0, 0);
            }
        }

        return visible;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            heights.add(sc.nextInt());
        }

        List<Integer> visibleFromLeft = visibleBuildingsFromLeft(heights);
        List<Integer> visibleFromRight = visibleBuildingsFromRight(heights);

        int visibleLeftCount = 0;
        int visibleRightCount = 0;

        for (int i : visibleFromLeft) {
            visibleLeftCount += i;
        }

        for (int i : visibleFromRight) {
            visibleRightCount += i;
        }

        System.out.println(visibleLeftCount + " " + visibleRightCount);
    }
}
```


