# Spring Boot JWT Example

![Project Build](https://github.com/zhouhao/spring-boot-jwt-example/workflows/Project%20Build/badge.svg)

This is a simple demo for spring boot with JWT integration, which supports user signup/login and blog creation/reading.

Note: this example project is inspired
by [Implementing JWT Authentication on Spring Boot APIs](https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/)
. Thanks for that nice blog post.

## How to Run

Note: This is a standard spring boot project with Maven, so you can use maven command to run it.

### Steps:

1. Run `docker-compose up` to start mariadb (*add `-d` if you want to start it as “detached” mode*).
2. Start spring boot project, either inside IDE, or with command line.
3. Play with this sample service with fun!

## Endpoint

### User

1. `POST`: `/signup`

It needs request payload as below, and it will return `200 OK` http status if succeeded.

```json
{
  "username": "nice-user-name",
  "password": "a-strong-password"
}
```

2. `POST`: `/login`

It needs the same request payload format as "signup", and it will return both access token and refresh token if
succeeded.

```json
{
  "username": "your-nice-user-name",
  "password": "your-strong-password"
}
```

3. `POST`: `/refresh_token`

It needs request payload as below, and it will return an access token if succeeded.

```json
{
  "refresh_token": "a-long-refresh-token-string"
}
```

4. `DELETE`: `/refresh_tokens`
   
With valid access token in the http header, you can purge all your stored refresh tokens in the database, in case you
   leak your refresh token. So after access token expires, the attacker cannot access your content anymore. (This is the
   reason why we should have a small TTL for access token.)

### Blog

1. `POST`: `/blog`
   
It needs request payload as below, and it will return `200 OK` http status if succeeded.

```json
{
  "title": "nice-blog-title",
  "content": "wonderful-blog-content"
}
```

2. `GET`: `/blog/{id}`
   
Fetch a single blog by its id.

3. `GET`: `/blogs`
   
Fetch all blogs belong to the request user.

