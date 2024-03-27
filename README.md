# todolist_SpringBoot
Spring Bootで作ったTODOリストです。<br>
![TODOリストのトップページ](https://github.com/puzzle-ap/todolist_SpringBoot/assets/149124533/79df2704-9b18-42b9-973f-158b1a1a4c6a)
# 使用技術
- HTML
- CSS
- Java
- Spring Boot
# 機能一覧
- ログイン機能
    - ログインに失敗した時にエラーメッセージを表示するとともに、再入力しやすくするためにセッションに格納したものをデフォルトの値にする
    - ログアウト機能
- TODOリストの名前と期限を入力し、追加ボタンを押すと、TODOリストが追加される
- TODOリストの完了にするボタンを押すと、完了になる
# データベース
tododbという名前のデータベースを使用しています。<br>
mst_userテーブルの構造<br>
![mst_user_desc](https://github.com/puzzle-ap/todolist_SpringBoot/assets/149124533/f35022ab-14eb-4fa2-946f-5436a07c31c8)<br>
mst_userテーブルの中身<br>
![mst_user_content](https://github.com/puzzle-ap/todolist_SpringBoot/assets/149124533/20e628b7-8b66-4a73-a5a7-d67522accef8)<br>
tbl_todolistの構造<br>
![tbl_todolist_desc](https://github.com/puzzle-ap/todolist_SpringBoot/assets/149124533/785c6d3b-2d5f-4a5c-9694-74a64ad0f370)<br>
tbl_todolistの中身<br>
![tbl_todolist_content](https://github.com/puzzle-ap/todolist_SpringBoot/assets/149124533/4e51473d-fa7e-43e6-96e5-945093723bf7)<br>


