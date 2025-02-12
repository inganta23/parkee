LOGFILE="update_log.txt"

if command -v apt > /dev/null; then
    echo "Updating packages using apt..." | tee -a "$LOGFILE"
    sudo apt update >> "$LOGFILE" 2>&1
    sudo apt upgrade -y >> "$LOGFILE" 2>&1
elif command -v yum > /dev/null; then
    echo "Updating packages using yum..." | tee -a "$LOGFILE"
    sudo yum update -y >> "$LOGFILE" 2>&1
else
    echo "Unsupported package manager." | tee -a "$LOGFILE"
    exit 1
fi

echo "Update completed." | tee -a "$LOGFILE"