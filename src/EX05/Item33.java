package EX05;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static EX05.Item33.Favorites.getAnnotation;

public class Item33 {
    /**
     * 타입 안정 이종 컨테이너를 고려하라
     *
     * 이종안전 컨테이너 ? 제너릭<> 타입으로 두번 처리하는 방식식
     * */


    public static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T instance) {
            favorites.put(Objects.requireNonNull(type), instance);
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }

        static Annotation getAnnotation(AnnotatedElement element,
                                        String annotationTypeName) {
            Class<?> annotationType = null; // 비한정적 타입 토큰
            try {
                annotationType = Class.forName(annotationTypeName);
            } catch (Exception ex) {
                throw new IllegalArgumentException(ex);
            }
            return element.getAnnotation(
                    annotationType.asSubclass(Annotation.class));
        }
    }

//    // 코드 33-4 동적 형변환으로 런타임 타입 안전성 확보 (202쪽)
//    public <T> void putFavorite(Class<T> type, T instance) {
//        favorites.put(Objects.requireNonNull(type), type.cast(instance));
//    }

    // 코드 33-2 타입 안전 이종 컨테이너 패턴 - 클라이언트 (199쪽)
    public static void main(String[] args) {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString,
                favoriteInteger, favoriteClass.getName());

        if (args.length != 2) {
            System.out.println(
                    "사용법: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        String className = args[0];
        String annotationTypeName = args[1];
        Class<?> klass = Class.forName(className);
        System.out.println(getAnnotation(klass, annotationTypeName));
    }
}
