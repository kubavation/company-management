package com.durys.jakub.companymanagement.configuration.util;

public class ConfigTypeResolver {

    public static void resolve(String configType) {
//
//        List<?> classes = Stream.of(ConfigurationGroup.values())
//                .map(ConfigurationGroup::getClasses)
//                .flatMap(Collection::stream)
//                .map(c -> {
//                    try {
//                        return c.newInstance();
//                    } catch (InstantiationException e) {
//                        e.printStackTrace();
//                        return null;
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                        return null;
//                    }
//                }).filter(Objects::nonNull)
//                .map(c -> {
//                    try {
//                        return Class.forName(c.declaringClassName())
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                        throw new RuntimeException();
//                    }
//                })
//                .map(c -> Enum.valueOf(c, configType))
//                .collect(Collectors.toList());
    }
}
