# monglog
MongoDB for Persisting Document Logs

## Curl:
curl -s -u goat:livesmatter GET "https://stage-apollo-13.timmythegoat.us/etc/clientlibs/sync-ids/productIds.json" > /tmp/failedId.json

## Insert:
mongoimport -h db -d monglog -c failed --file /tmp/failed.json

