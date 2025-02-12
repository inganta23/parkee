import pandas as pd
import os


directory = 'data/'
all_files = [os.path.join(directory, f) for f in os.listdir(directory) if f.endswith('.csv')]

df_list = [pd.read_csv(file) for file in all_files]
combined_df = pd.concat(df_list, ignore_index=True)

cleaned_df = combined_df.dropna(subset=['transaction_id', 'date', 'customer_id'])

cleaned_df['date'] = pd.to_datetime(cleaned_df['date'])

cleaned_df = cleaned_df.sort_values('date', ascending=False).drop_duplicates('transaction_id', keep='first')
cleaned_df.to_csv('output/merged_branch.csv', index=False)

cleaned_df['total_sales'] = cleaned_df['quantity'] * cleaned_df['price']

total_sales_per_branch = cleaned_df.groupby('branch')['total_sales'].sum().reset_index()

total_sales_per_branch.to_csv('output/total_sales_per_branch.csv', index=False)

print("Data telah dibersihkan dan total penjualan per cabang telah disimpan ke 'total_sales_per_branch.csv'")