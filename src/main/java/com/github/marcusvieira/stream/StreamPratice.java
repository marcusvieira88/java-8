package com.github.marcusvieira.stream;

import com.github.marcusvieira.dto.TwitterPost;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamPratice {

    public static void main(String[] args) {

        List<TwitterPost> posts1 = new LinkedList<>();
        posts1.add(new TwitterPost("marcus1","soccer", LocalDate.now()));
        posts1.add(new TwitterPost("marcus3","soccer", LocalDate.now()));
        posts1.add(new TwitterPost("marcus2","hockey", LocalDate.now()));
        posts1.add(new TwitterPost("marcus5","soccer", LocalDate.now()));
        posts1.add(new TwitterPost("marcus4","hockey", LocalDate.now()));

        List<TwitterPost> posts2 = new LinkedList<>();
        posts2.add(new TwitterPost("marcus6","soccer", LocalDate.now()));
        posts2.add(new TwitterPost("marcus8","soccer", LocalDate.now()));
        posts2.add(new TwitterPost("marcus10","hockey", LocalDate.now()));
        posts2.add(new TwitterPost("marcus7","soccer", LocalDate.now()));
        posts2.add(new TwitterPost("marcus9","hockey", LocalDate.now()));

        Collections.unmodifiableList(posts1);
        Collections.unmodifiableList(posts2);

        System.out.println("------ print all userId items -------");
        posts1.stream()
                .map(twitterPost -> {return twitterPost.getUserId();})
                .forEach(System.out :: println);

        System.out.println("------ sort by get userId version 1 -------");
        posts1.stream()
                .sorted((o1, o2) -> {return o1.getUserId().compareTo(o2.getUserId());})
                .forEach(System.out :: println);

        System.out.println("------ sort by get userId version 2 -------");
        posts1.stream()
                .sorted(Comparator.comparing(TwitterPost::getUserId))
                .forEach(System.out :: println);

        System.out.println("------ sort by get userId version 2 -------");
        posts1.stream()
                .filter(twitterPost -> {return twitterPost.getThema().equals("soccer");})
                .map(twitterPost -> {return twitterPost.getThema();})
                .forEach(System.out :: println);

        System.out.println("------ map version 1 -------");
        Stream.of(posts1,posts2)
                .map(twitterPosts -> {return twitterPosts.stream();})
                .forEach(System.out :: println);

        System.out.println("------ flatmap version 1 -------");
        Stream.of(posts1,posts2)
                .flatMap(twitterPosts -> {return twitterPosts.stream();})
                .forEach(System.out :: println);

        System.out.println("------ flatmap version 2 -------");
        Stream.of(posts1,posts2)
                .flatMap(twitterPosts -> {return twitterPosts.stream();})
                .map(twitterPost -> {return twitterPost.getUserId();})
                .forEach(System.out :: println);

        System.out.println("------ count -------");
        long count = Stream.of(posts1, posts2)
                            .flatMap(twitterPosts -> {return twitterPosts.stream();})
                            .count();
        System.out.println("count= " + count);

        System.out.println("------ findFirst -------");
        Optional<TwitterPost> first = Stream.of(posts1, posts2)
                .flatMap(twitterPosts -> {return twitterPosts.stream();})
                .findFirst();
        System.out.println("first= " + first);

        System.out.println("------ findFirst null -------");
        Optional<TwitterPost> first2 = new ArrayList<TwitterPost>().stream()
                .findFirst();
        System.out.println("first2.isPresent()= " + first2.isPresent());

        System.out.println("------ distinct -------");
        Stream.of(posts1, posts1)
                .flatMap(twitterPosts -> {return twitterPosts.stream();})
                .distinct()
                .forEach(System.out :: println);

        System.out.println("------ limit -------");
        Stream.of(posts1, posts1)
                .flatMap(twitterPosts -> {return twitterPosts.stream();})
                .limit(2)
                .forEach(System.out :: println);

        System.out.println("------ flatMapToInt -------");
        posts1.stream()
                .flatMapToInt(twitterPost -> {
                    return IntStream.of(Integer.parseInt(twitterPost.getUserId().substring(twitterPost.getUserId().length() - 1,twitterPost.getUserId().length())));
                })
                .forEach(System.out :: println);

        System.out.println("------ flatMapToLong -------");
        posts1.stream()
                .flatMapToLong(twitterPost -> {
                    return LongStream.of(Long.parseLong(twitterPost.getUserId().substring(twitterPost.getUserId().length() - 1,twitterPost.getUserId().length())));
                })
                .forEach(System.out :: println);

        System.out.println("------ skip -------");
        posts1.stream()
                .skip(3)
                .forEach(System.out :: println);

        System.out.println("------ reduce -------");
        Integer reduce = posts1.stream()
                .map(twitterPost -> {
                    return Integer.parseInt(twitterPost.getUserId().substring(twitterPost.getUserId().length() - 1, twitterPost.getUserId().length()));
                })
                .reduce(0, (left, right) -> {
                    return left + right;
                });
        System.out.println("reduce= " + reduce);

        System.out.println("------ anyMatch -------");
        boolean anyMatch = posts1.stream()
                .anyMatch(twitterPost -> {
                    return twitterPost.getUserId().equals("marcus1");
                });
        System.out.println("anyMatch= " + anyMatch);

        System.out.println("------ allMatch -------");
        boolean allMatch = posts1.stream()
                .allMatch(twitterPost -> {
                    return twitterPost.getUserId().equals("marcus1");
                });
        System.out.println("allMatch= " + allMatch);

        System.out.println("------ parallel and forEach -------");
        posts1.stream().parallel()
                .forEach(System.out :: println);

        System.out.println("------ parallel and forEachOrdered -------");
        posts1.stream().parallel()
                .forEachOrdered(System.out :: println);

        System.out.println("------ max and ifPresent -------");
        posts1.stream()
                .max(Comparator.comparing(TwitterPost::getUserId))
                .ifPresent(System.out :: println);

        System.out.println("------ collectors toList-------");
        posts1.stream()
                .collect(Collectors.toList())
                .forEach(System.out :: println);

        System.out.println("------ collectors toMap-------");
        posts1.stream()
                .collect(Collectors.toMap(TwitterPost :: getUserId, o -> o ))
                .forEach((s, twitterPost) -> {
                    System.out.println(twitterPost);
                });
    }


}
