if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <start|stop|status> <service_name>"
    exit 1
fi

ACTION=$1
SERVICE=$2

case $ACTION in
    start)
        sudo systemctl start "$SERVICE"
        echo "$SERVICE started."
        ;;
    stop)
        sudo systemctl stop "$SERVICE"
        echo "$SERVICE stopped."
        ;;
    status)
        sudo systemctl status "$SERVICE"
        ;;
    *)
        echo "Invalid action. Use start, stop, or status."
        exit 1
        ;;
esac