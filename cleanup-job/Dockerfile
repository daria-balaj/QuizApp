FROM postgres:alpine

COPY cleanup.sh /cleanup.sh
COPY crontab.txt /etc/crontabs/root

RUN chmod +x /cleanup.sh

CMD ["crond", "-f"]