package com.merenaas.models;

public enum OrderStatusEnum {
    TREATMENT {
        @Override
        public String toString(){
            return "В обработке";
        }
    },
    COLLECTION {
        @Override
        public String toString(){
            return "Сборка заказа";
        }
    },
    SHIPPED {
        @Override
        public String toString(){
            return "Заказ отправлен";
        }
    },
    DELIVERED_TO {
        @Override
        public String toString(){
            return "Заказ доставлен клиенту";
        }
    },
    SENT_BACK {
        @Override
        public String toString(){
            return "Книги отправлены в библиотеку";
        }
    },
    COMPLETED {
        @Override
        public String toString(){
            return "Завершен";
        }
    }
}
