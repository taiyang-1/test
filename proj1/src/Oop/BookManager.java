package Oop;

/**
 * @author lyf
 */
public class BookManager {
    private Book[] books;
    private int size;

//创建对象时需要输入数组长度
public BookManager(int size){
    books = new Book[size];
}
//添加方法
public void addBook(Book book){
    if(size == books.length){
        System.out.println(("数组已满"));
        return;
    }else{
        books[size]= book;
        size++;
        System.out.println("添加成功");
    }
}
public void deleteByTitle(String title){
   int index = books.length;
   if (index == -1){
       System.out.println("未找到该书籍");
   }
    for (int i = 0; i < size; i++) {
        if(title.equals(books[i].getTitle())){
            for (int j = i; j < size - 1; j++) {
                books[j] = books[j + 1];
            }
            books[size - 1] = null;  // 清空最后一个位置
            size--;
            System.out.println("删除成功");
            return;
        }

    }
    }
   }


