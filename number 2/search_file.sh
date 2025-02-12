if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <directory> <extension>"
    exit 1
fi

DIRECTORY=$1
EXTENSION=$2

find "$DIRECTORY" -type f -name "*.$EXTENSION"