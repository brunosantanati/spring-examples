Commands

```
sudo systemctl stop mysql
docker compose up -d
docker exec -it mysql_tasks_test mysql -h 127.0.0.1 -u taskuser -ptaskpassword taskdb
docker logs -f mysql_tasks_test
docker compose down -v
docker compose up -d --force-recreate

curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Estudar Spring e Hibernate",
    "description": "Preparação para o teste da entrevista de emprego",
    "status": "PENDING"
  }'

curl -X PUT http://localhost:8080/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Estudar Spring Boot e Hibernate",
    "description": "Revisar anotação @Transactional, DTOs e Bean Validation para a entrevista",
    "status": "IN_PROGRESS"
  }'
  
curl -X GET "http://localhost:8080/api/tasks?status=IN_PROGRESS"

curl -X GET "http://localhost:8080/api/tasks?status=IN_PROGRESS&title=Spring"
```