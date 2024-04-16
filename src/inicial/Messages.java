package inicial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Messages {

	// Función para reconstruir el mensaje original
    public static String GetMessage(String[][] messages) {
    	// Inicializa una lista vacía para almacenar el mensaje reconstruido
        List<String> reconstructedMessage = new ArrayList<>();

     // Determinar el número máximo de partes del mensaje (considerando el desfasaje)
        int maxMessageParts = 0;
        for (String[] message : messages) {
            maxMessageParts = Math.max(maxMessageParts, message.length);
        }

     // Iterar sobre todas las partes del mensaje (considerando el desfasaje) 
        for (int i = 0; i < maxMessageParts; i++) {
        	// Comprobar si hay palabras que no estén vacías en cada mensaje del dispositivo
            for (String[] message : messages) {
                if (!message[i].isEmpty()) {
                    reconstructedMessage.add(message[i]);
                    break; // Agrega la primera palabra que no esté vacía y pasa a la siguiente parte del mensaje
                }
            }
        }

     // Une las partes del mensaje reconstruido en una sola cadena
        String reconstructedMessageString = String.join(" ", reconstructedMessage);

     // Devuelve el mensaje reconstruido
        return reconstructedMessageString;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
    	// Mensajes de muestra recibidos por diferentes dispositivos
        String[][] messages = {
                {"", "este", "es", "un", "mensaje"},
                {"este", "", "un", "mensaje"},
                {"", "", "es", "", "mensaje"}
        };

     // Reconstruir el mensaje original
        String reconstructedMessage = GetMessage(messages);

     // Imprime el mensaje reconstruido
        System.out.println("Mensaje reconstruido: " + reconstructedMessage);
    }
}
