package com.crud.deportes.utils.response;

import java.util.List;

public class ErrorResponse {
    private List<ErrorDetails> errores;

    public List<ErrorDetails> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorDetails> errores) {
        this.errores = errores;
    }

    public static class ErrorDetails {
        private String campo;
        private String mensaje;

        public String getCampo() {
            return campo;
        }

        public void setCampo(String campo) {
            this.campo = campo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

    }
}
