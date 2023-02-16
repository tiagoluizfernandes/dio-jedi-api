package br.com.tts.dio.diojediapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Tiago Luiz Fernandes
 */
public class Jedi {

    @NotBlank (message= "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    private String name;
    @Size(max = 20, message = "Last Name must not have more than 20 letters")
    private String lastName;

    public Jedi() {

    }
    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
