USE [master]
GO
/****** Object:  Database [InternshipManagement]    Script Date: 11/11/2024 4:07:33 PM ******/
CREATE DATABASE [InternshipManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'InternshipManagement', FILENAME = N'D:\TailieuLuutru\INTERNSHIP\SETUP\MSSQL16.MSSQLSERVER\MSSQL\DATA\InternshipManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'InternshipManagement_log', FILENAME = N'D:\TailieuLuutru\INTERNSHIP\SETUP\MSSQL16.MSSQLSERVER\MSSQL\DATA\InternshipManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [InternshipManagement] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [InternshipManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [InternshipManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [InternshipManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [InternshipManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [InternshipManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [InternshipManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [InternshipManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [InternshipManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [InternshipManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [InternshipManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [InternshipManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [InternshipManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [InternshipManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [InternshipManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [InternshipManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [InternshipManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [InternshipManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [InternshipManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [InternshipManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [InternshipManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [InternshipManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [InternshipManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [InternshipManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [InternshipManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [InternshipManagement] SET  MULTI_USER 
GO
ALTER DATABASE [InternshipManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [InternshipManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [InternshipManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [InternshipManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [InternshipManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [InternshipManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'InternshipManagement', N'ON'
GO
ALTER DATABASE [InternshipManagement] SET QUERY_STORE = ON
GO
ALTER DATABASE [InternshipManagement] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [InternshipManagement]
GO
USE [InternshipManagement]
GO
/****** Object:  Sequence [dbo].[grade_entity_seq]    Script Date: 11/11/2024 4:07:34 PM ******/
CREATE SEQUENCE [dbo].[grade_entity_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[audit_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[audit_entity](
	[audit_id] [varchar](255) NOT NULL,
	[date] [date] NULL,
	[evaluation_period] [smallint] NULL,
	[mentor_id] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[audit_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[audit_intern_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[audit_intern_entity](
	[audit_intern_id] [varchar](255) NOT NULL,
	[auditid] [varchar](255) NULL,
	[ave_grade] [float] NOT NULL,
	[created_time] [datetime2](6) NULL,
	[intern_id] [varchar](255) NULL,
	[result_id] [varchar](255) NULL,
	[updated_time] [datetime2](6) NULL,
PRIMARY KEY CLUSTERED 
(
	[audit_intern_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[audit_participants]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[audit_participants](
	[audit_intern_id] [varchar](255) NOT NULL,
	[role] [smallint] NULL,
	[user_id] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[audit_intern_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[audit_result_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[audit_result_entity](
	[result_id] [varchar](255) NOT NULL,
	[ave_result] [float] NOT NULL,
	[create_time] [datetime2](6) NULL,
	[feedback_id] [int] NOT NULL,
	[intern_id] [varchar](255) NULL,
	[mentor_id] [varchar](255) NULL,
	[result] [bit] NOT NULL,
	[is_qualify] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[result_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[daily_report_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[daily_report_entity](
	[report_id] [int] NOT NULL,
	[created_time] [datetime2](6) NULL,
	[intern_id] [varchar](255) NULL,
	[is_reviewed] [bit] NOT NULL,
	[mentor_id] [varchar](255) NULL,
	[today] [datetime2](6) NULL,
	[todo_list] [varchar](255) NULL,
	[updated_time] [datetime2](6) NULL,
PRIMARY KEY CLUSTERED 
(
	[report_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[feedback_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[feedback_entity](
	[feedback_id] [int] NOT NULL,
	[created_time] [datetime2](6) NULL,
	[description] [varchar](255) NULL,
	[intern_id] [int] NOT NULL,
	[mentor_id] [int] NOT NULL,
	[value] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[feedback_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[grade_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[grade_entity](
	[grade_id] [int] NOT NULL,
	[audit_intern_id] [varchar](255) NULL,
	[description] [varchar](255) NULL,
	[name] [smallint] NULL,
	[value] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[grade_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[intern_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[intern_entity](
	[avatar] [varchar](255) NULL,
	[join_date] [date] NULL,
	[mentor_id] [varchar](255) NULL,
	[status] [smallint] NULL,
	[user_id] [varchar](255) NOT NULL,
	[first_pass] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[issue_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[issue_entity](
	[issue_id] [int] NOT NULL,
	[issue_content] [varchar](255) NULL,
	[report_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[issue_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[issue_receiver_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[issue_receiver_entity](
	[receiver_id] [int] NOT NULL,
	[issue_id] [varchar](255) NULL,
	[reply] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[receiver_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mentor_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mentor_entity](
	[bu] [varchar](255) NULL,
	[user_id] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[task_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[task_entity](
	[task_id] [int] NOT NULL,
	[completed_time] [datetime2](6) NULL,
	[created_time] [datetime2](6) NULL,
	[is_completed] [bit] NOT NULL,
	[report_id] [int] NOT NULL,
	[task_content] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_entity]    Script Date: 11/11/2024 4:07:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_entity](
	[user_id] [varchar](255) NOT NULL,
	[account] [varchar](255) NOT NULL,
	[address] [varchar](255) NULL,
	[dob] [date] NULL,
	[full_name] [varchar](255) NULL,
	[gender] [bit] NOT NULL,
	[password] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[role] [smallint] NULL,
	[social_num] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UKqpyntoml7p4g7nb8hggn6of20] UNIQUE NONCLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[intern_entity]  WITH CHECK ADD  CONSTRAINT [FKffijht7m1ht0d6v739v7g05ga] FOREIGN KEY([user_id])
REFERENCES [dbo].[user_entity] ([user_id])
GO
ALTER TABLE [dbo].[intern_entity] CHECK CONSTRAINT [FKffijht7m1ht0d6v739v7g05ga]
GO
ALTER TABLE [dbo].[mentor_entity]  WITH CHECK ADD  CONSTRAINT [FKeh56rkd1c4i9xnp2tgbb8a6u6] FOREIGN KEY([user_id])
REFERENCES [dbo].[user_entity] ([user_id])
GO
ALTER TABLE [dbo].[mentor_entity] CHECK CONSTRAINT [FKeh56rkd1c4i9xnp2tgbb8a6u6]
GO
ALTER TABLE [dbo].[audit_entity]  WITH CHECK ADD CHECK  (([evaluation_period]>=(0) AND [evaluation_period]<=(2)))
GO
ALTER TABLE [dbo].[audit_participants]  WITH CHECK ADD CHECK  (([role]>=(0) AND [role]<=(1)))
GO
ALTER TABLE [dbo].[grade_entity]  WITH CHECK ADD CHECK  (([name]>=(0) AND [name]<=(2)))
GO
ALTER TABLE [dbo].[intern_entity]  WITH CHECK ADD CHECK  (([status]>=(0) AND [status]<=(2)))
GO
ALTER TABLE [dbo].[user_entity]  WITH CHECK ADD CHECK  (([role]>=(0) AND [role]<=(1)))
GO
USE [master]
GO
ALTER DATABASE [InternshipManagement] SET  READ_WRITE 
GO
