if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <directory> <key_name>"
    exit 1
fi

DIRECTORY=$1
KEY_NAME=$2

mkdir -p "$DIRECTORY"

ssh-keygen -t rsa -b 2048 -f "$DIRECTORY/$KEY_NAME" -N ""
echo "SSH key created at $DIRECTORY/$KEY_NAME"