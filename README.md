# library-app

Default accounts:
ADMIN ROLE:
login: admin
password: admin

USER ROLE
login: user
password: user

#####################################################

1. For unauthorized you can use 2 endpoints:
/login   -   to log-in
/register   -   to register

REGISTRATION EXAMPLE:
POST / Body in JSON
{
    "id": 3,
    "myBook": [],
    "username": "user2",
    "password": "user2",
    "role": "ROLE_USER"
}

#####################################################

2. When you log-in as a User, you can use endpoints:

/api/books/all   -   to see all the books
/api/users/{userId}    -   to see your books
/api/books/{bookId}/rent/{userId}    -    to rent a book

#####################################################

3. When you log-in as a Admin, you can use endpoints:

/api/books/all   -   to see all the books
/api/books/    -   (PUT, POST, DELETE) to manage books
/api/users/all    -    to see all users
