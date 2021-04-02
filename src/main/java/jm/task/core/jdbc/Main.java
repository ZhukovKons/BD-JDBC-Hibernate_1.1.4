//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jm.task.core.jdbc;

import java.util.Random;
import java.util.stream.Collectors;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();

        for(int i = 0; i < 5; ++i) {
            service.saveUser(runString(), runString(), (byte)((int)Math.abs(Math.random() * 100.0D)));
        }

        service.getAllUsers().forEach((u) -> {
            System.out.println(u.toString());
        });
//        service.removeUserById(1);
        service.cleanUsersTable();
        service.dropUsersTable();
    }

    private static String runString() {
        String string = (String)(new Random()).ints((long)(Math.random() * 10.0D + 8.0D) / 2L, 0, "abcdefghijklmnopqrstuvwxyz".length()).mapToObj("abcdefghijklmnopqrstuvwxyz"::charAt).map(Object::toString).collect(Collectors.joining());
        return Character.toString(string.charAt(0)).toUpperCase() + string.substring(1);
    }
}
