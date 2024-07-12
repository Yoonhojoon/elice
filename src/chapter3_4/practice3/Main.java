package chapter3_4.practice3;


class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Product product = new Product("텀블러", 0); // 재고 수량을 변경하여 테스트하세요.

        try {
            addProductToCart(product);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("장바구니 업데이트를 시도했습니다.");
        }
    }

    static void addProductToCart(Product product) throws OutOfStockException {
        if (product.getStock() <= 0) {
            throw new OutOfStockException("상품 " + product.getName() + "은/는 재고가 없습니다.");
        }

        // 상품 추가 로직 (생략)
    }
}
