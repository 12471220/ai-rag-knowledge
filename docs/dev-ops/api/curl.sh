curl http://localhost:11434/api/generate \
  -H "Content-Type: application/json" \
  -d '{
        "model": "deepseek-r1:1.5b",
        "prompt": "1+1等于几？",
        "stream": false
      }'