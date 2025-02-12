if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <source_file> <username> <ip_address>"
    exit 1
fi

SOURCE_FILE=$1
USERNAME=$2
IP_ADDRESS=$3

rsync -avz "$SOURCE_FILE" "$USERNAME@$IP_ADDRESS:~/"