#!/bin/sh
psql -h database -U postgres -d quizapp -c \
"DELETE FROM matches WHERE matches.completed_at < NOW() - INTERVAL '3 days';"