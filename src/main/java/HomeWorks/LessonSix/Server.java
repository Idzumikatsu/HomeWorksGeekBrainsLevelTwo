package HomeWorks.LessonSix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
        public static void main(String[] args) {
            Socket clientSocket = null;
            Scanner scanner = new Scanner(System.in);

            try (ServerSocket serverSocket = new ServerSocket(7777)) {
                System.out.println("Сервер запущен");
                clientSocket = serverSocket.accept();
                System.out.println("Подключен клиент: " + clientSocket.getRemoteSocketAddress());
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                //Поток на чтение
                Thread threadReader = new Thread(() -> {
                    try {
                        while (true) {
                            outputStream.writeUTF(scanner.nextLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                threadReader.setDaemon(true);
                threadReader.start();

                while (true) {
                    String str = inputStream.readUTF();
                    if (str.equals("/end")) {
                        System.out.println("Клиент покинул сервер");
                        outputStream.writeUTF("/end");
                        break;
                    } else {
                        System.out.println("Клиент: " + str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
}
